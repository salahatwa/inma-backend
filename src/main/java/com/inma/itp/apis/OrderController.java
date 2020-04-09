package com.inma.itp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inma.itp.config.annotations.CurrentUser;
import com.inma.itp.config.secuirty.UserPrincipal;
import com.inma.itp.messaging.MessageTemplateService;
import com.inma.itp.models.dto.OrderRequest;
import com.inma.itp.models.queues.ETradeOrdMngRq;
import com.inma.itp.models.queues.ETradeOrdMngRs;
import com.inma.itp.models.queues.ETradeOrdsInqRq;
import com.inma.itp.models.queues.ETradeOrdsInqRs;

/**
 * Api to for order managing
 * 
 * @author ssatwa
 *
 */
@RestController
@RequestMapping("${api.context.path}/order")
public class OrderController {

	@Autowired
	private MessageTemplateService msgTemplateService;

	/**
	 * Execute Order
	 * 
	 * @param currentUser
	 * @param orderRequest
	 * @return reference for order
	 */
	@PostMapping("/execute")
	public ResponseEntity<?> executeOrder(@CurrentUser UserPrincipal currentUser, @RequestBody OrderRequest ordReq) {

		ETradeOrdMngRq request = new ETradeOrdMngRq("33000000", currentUser.getId());
		request.getBody().geteTradeOrdDtls().setProduct("LE");
		request.getBody().geteTradeOrdDtls().setMinFillQty(ordReq.getMinFillQty() + "");
		request.getBody().geteTradeOrdDtls().setTifType(ordReq.getTifType() + "");
		request.getBody().geteTradeOrdDtls().setExpDt("DEPEND ON TifType()");
		request.getBody().geteTradeOrdDtls().setPortfolioNum(ordReq.getWalletNumber());
		request.getBody().geteTradeOrdDtls().setSymbol(ordReq.getStockSymbol());
		request.getBody().geteTradeOrdDtls().setOrdSide(ordReq.getOrderSide());
		request.getBody().geteTradeOrdDtls().setOrdType(String.valueOf(ordReq.getOrderType()));
		request.getBody().geteTradeOrdDtls().setOrdQty(String.valueOf(ordReq.getOrderQty()));
		request.getBody().geteTradeOrdDtls().getCurAmt().setAmt(String.valueOf(ordReq.getUnitPrice()));

		ETradeOrdMngRs rs = msgTemplateService.sendMessage(request, ETradeOrdMngRs.class);

		return ResponseEntity.ok(rs.getMsgRsHdr());
	}

	@PostMapping("/inquiry")
	public ResponseEntity<?> inquiryOrders(@CurrentUser UserPrincipal currentUser, @RequestBody OrderRequest ordReq) {

		ETradeOrdsInqRq request = new ETradeOrdsInqRq("32000010", currentUser.getId());

		ETradeOrdsInqRs rs = msgTemplateService.sendMessage(request, ETradeOrdsInqRs.class);

		System.out.println(rs.getBody().getOrdsList().geteTradeOrdDtls().size());
		return ResponseEntity.ok(rs.getBody().getOrdsList().geteTradeOrdDtls());
	}
}
