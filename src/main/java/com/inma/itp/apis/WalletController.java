package com.inma.itp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inma.itp.config.annotations.CurrentUser;
import com.inma.itp.config.secuirty.UserPrincipal;
import com.inma.itp.messaging.MessageTemplateService;
import com.inma.itp.models.dto.CommissionRequest;
import com.inma.itp.models.queues.ETradeCustPortfoliosInqRq;
import com.inma.itp.models.queues.ETradeCustPortfoliosInqRs;
import com.inma.itp.models.queues.ETradePreOrdDtlsInqRq;
import com.inma.itp.models.queues.ETradePreOrdDtlsInqRs;

/**
 * Api to return wallet details
 * 
 * @author ssatwa
 *
 */
@RestController
@RequestMapping("${api.context.path}/wallet")
public class WalletController {

	@Autowired
	private MessageTemplateService msgTemplateService;

	/**
	 * Get all wallet details by stock number and wallet number
	 * 
	 * @param currentUser
	 * @param stockSymbol
	 * @param walletNumber
	 * @return wallet details 
	 */
	@GetMapping("/{stockSymbol}/{walletNumber}/details")
	public ResponseEntity<?> getWalletDetailsByStockAndWalletNumber(@CurrentUser UserPrincipal currentUser,
			@PathVariable("stockSymbol") String stockSymbol, @PathVariable("walletNumber") String walletNumber) {

		ETradeCustPortfoliosInqRq request = new ETradeCustPortfoliosInqRq("32021000", currentUser.getId(), null);
		request.getBody().setPortfolioNum(walletNumber);
		request.getBody().setPortfolioType("IP");
		request.getBody().setSymbol(stockSymbol);
		ETradeCustPortfoliosInqRs rs = msgTemplateService.sendMessage(request, ETradeCustPortfoliosInqRs.class);

//		WalletDetails walletDetails=new WalletDetails();
//		BeanUtils.copyProperties(rs.getBody().getPortfoliosList().getPortfolioDtls(), walletDetails);
//		BeanUtils.copyProperties(rs.getBody().getPortfoliosList().getPortfolioDtls().getAcctId(), walletDetails.getAcctId());
//		BeanUtils.copyProperties(rs.getBody().getPortfoliosList().getPortfolioDtls().getTradeSecsList().getTradeSec(), walletDetails.getTradeSecsList().getTradeSec());
		return ResponseEntity.ok(rs.getBody().getPortfoliosList().getPortfolioDtls().get(0));
	}

	/**
	 * Get all wallets details for given POI Number
	 * 
	 * @param currentUser
	 * @param poiNumber
	 * @return List of wallets details
	 */
	@GetMapping("/{poiNumber}/details")
	public ResponseEntity<?> getAllWalletDetailsForPoiNumber(@CurrentUser UserPrincipal currentUser,
			@PathVariable("poiNumber") String poiNumber) {

		ETradeCustPortfoliosInqRq request = new ETradeCustPortfoliosInqRq("32020000", currentUser.getId(), poiNumber);
		ETradeCustPortfoliosInqRs rs = msgTemplateService.sendMessage(request, ETradeCustPortfoliosInqRs.class);

		return ResponseEntity.ok(rs.getBody().getPortfoliosList().getPortfolioDtls());
	}
	
	
	
	/**
	 * Get all commission details
	 * 
	 * @param currentUser
	 * @param commissionRequest
	 * @return Commission details
	 */
	@PostMapping("/commission/details")
	public ResponseEntity<?> getCommissionDetails(@CurrentUser UserPrincipal currentUser,
			@RequestBody CommissionRequest commReq) {

		ETradePreOrdDtlsInqRq request = new ETradePreOrdDtlsInqRq("32130000", currentUser.getId());
		request.getBody().setPortfolioNum(commReq.getWalletNumber());
		request.getBody().setSymbol(commReq.getStockSymbol());
		request.getBody().setOrdSide(commReq.getOrderSide());
		request.getBody().setOrdType(String.valueOf(commReq.getOrderType()));
		request.getBody().setOrdQty(String.valueOf(commReq.getOrderQty()));
		request.getBody().setUnitPrice(String.valueOf(commReq.getUnitPrice()));
		
		ETradePreOrdDtlsInqRs rs = msgTemplateService.sendMessage(request, ETradePreOrdDtlsInqRs.class);

		return ResponseEntity.ok(rs.getBody());
	}
}
