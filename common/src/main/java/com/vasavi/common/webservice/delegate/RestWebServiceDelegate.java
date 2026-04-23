package com.vasavi.common.webservice.delegate;

import com.vasavi.common.webservice.model.RestWebServiceRequest;
import com.vasavi.common.webservice.model.RestWebServiceResponse;

public interface RestWebServiceDelegate {

    RestWebServiceResponse invoke(RestWebServiceRequest request, Object object);
}