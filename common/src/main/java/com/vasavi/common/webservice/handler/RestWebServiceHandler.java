package com.vasavi.common.webservice.handler;

import com.vasavi.common.webservice.delegate.RestWebServiceDelegate;
import com.vasavi.common.webservice.model.RestWebServiceRequest;
import com.vasavi.common.webservice.model.RestWebServiceResponse;

public interface RestWebServiceHandler {

    RestWebServiceRequest prepareRequest(Object input, Object object);

    void processResponse(RestWebServiceResponse response, Object object);

    RestWebServiceDelegate delegate();
}