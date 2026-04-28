package com.vasavi.common.webservice.facade;

import com.vasavi.common.webservice.handler.RestWebServiceHandler;
import com.vasavi.common.webservice.model.RestWebServiceRequest;
import com.vasavi.common.webservice.model.RestWebServiceResponse;
import com.vasavi.common.webservice.delegate.RestWebServiceDelegate;

public class RestWebServiceFacade {

    public void initiate(RestWebServiceHandler handler, Object input, Object object) {

        // Step 1: prepare request
        RestWebServiceRequest request = handler.prepareRequest(input, object);

        // Step 2: get delegate
        RestWebServiceDelegate delegate = handler.delegate();

        // Step 3: call API
        RestWebServiceResponse response = delegate.invoke(request, object);

        // Step 4: process response
        handler.processResponse(response, object);
    }
}