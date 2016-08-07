package org.apache.camel.example.cxf.mock;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.example.reportincident.OutputReportIncident;
import org.apache.camel.example.reportincident.OutputReportIncidentLegacy;
import org.apache.cxf.message.MessageContentsList;

public class CXFWebservicePostProcessor implements Processor {

	public void process(Exchange ex) throws Exception {
		OutputReportIncidentLegacy lOut = (OutputReportIncidentLegacy) ((MessageContentsList) ex.getIn().getBody()).get(0);
		
		OutputReportIncident out = new OutputReportIncident();
		out.setCode("OK;" + lOut.getCodeLegacy());
		ex.getOut().setBody(out);		
	}

}
