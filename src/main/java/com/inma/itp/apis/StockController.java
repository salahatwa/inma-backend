package com.inma.itp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inma.itp.config.annotations.CurrentUser;
import com.inma.itp.config.secuirty.UserPrincipal;
import com.inma.itp.messaging.MessageTemplateService;
import com.inma.itp.models.queues.SecsInqRq;
import com.inma.itp.models.queues.SecsInqRs;

/**
 * Api to return stock details by stock symbol
 * @author ssatwa
 *
 */
@RestController
@RequestMapping("${api.context.path}/stock")
public class StockController {
	
	@Autowired
	private MessageTemplateService msgTemplateService;

	@GetMapping("/{symbol}/details")
	public ResponseEntity<?> authenticateUser(@CurrentUser UserPrincipal currentUser,
			@PathVariable("symbol") String symbol) {

		SecsInqRq request=new SecsInqRq("32110000",currentUser.getId());
		request.getBody().setProductCode("LSH");
		request.getBody().setSymbol(symbol);
		SecsInqRs rs = msgTemplateService.sendMessage(request, SecsInqRs.class);
		
//		StockDetails stockDetails=new StockDetails();
//		BeanUtils.copyProperties(rs.getBody().getSecList().getSecRec(), stockDetails);
		return ResponseEntity.ok(rs.getBody().getSecList().getSecRec().get(0));
	}
}
