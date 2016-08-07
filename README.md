# CXF WebService Transformation Endpoint Example

### Introduction

An example which provides an endpoint w/ transformation using Camel CXF.

Based on the Camel CXF Proxy Example <http://camel.apache.org/cxf-proxy-example.html>

SOAP Endpoint will be exposed at http://localhost:8989/camel-example-cxf-mock/webservices/incident?wsdl


Any liability is excluded.


### Mockendpoint

Mock endpoint expected on http://localhost:8080/service w/ the following response:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:rep="http://reportincident.example.camel.apache.org">
   <soapenv:Header/>
   <soapenv:Body>
      <rep:outputReportIncidentLegacy>
         <codeLegacy>1234</codeLegacy>
      </rep:outputReportIncidentLegacy>
   </soapenv:Body>
</soapenv:Envelope>
