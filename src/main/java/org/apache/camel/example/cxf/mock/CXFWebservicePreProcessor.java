package org.apache.camel.example.cxf.mock;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.example.reportincident.InputReportIncident;
import org.apache.camel.example.reportincident.InputReportIncidentLegacy;
import org.apache.cxf.message.MessageContentsList;

public class CXFWebservicePreProcessor implements Processor {

	public void process(Exchange ex) throws Exception {
		
		MessageContentsList msgList = (MessageContentsList) ex.getIn().getBody();
		
		InputReportIncident inc = (InputReportIncident) msgList.get(0);;		
		InputReportIncidentLegacy legacy = new InputReportIncidentLegacy();
		legacy.setGivenNameLegacy(inc.getGivenName());
		legacy.setDetailsLegacy(inc.getDetails());
		legacy.setEmailLegacy(inc.getEmail());
		legacy.setIncidentIdLegacy(inc.getIncidentId());
		
		ex.getIn().setHeader(CxfConstants.OPERATION_NAME, "ReportIncidentLegacy");
		
		//http://reportincident.example.camel.apache.org
		
		// [...]

		ex.getIn().setBody(legacy);
		
	}

}
