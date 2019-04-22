package com.taianemaia.wsdlserver.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.taianemaia.wsdlserver.assets.GetPaisRequest;
import com.taianemaia.wsdlserver.assets.GetPaisResponse;
import com.taianemaia.wsdlserver.repositories.PaisRepository;

@Endpoint
public class PaisEndpoint {
    private static final String NAMESPACE_URI = "http://taianemaia.com.br/wsdlserver/assets";

    private final PaisRepository paisRepository;

    public PaisEndpoint(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
    @ResponsePayload
    public GetPaisResponse getCountry(@RequestPayload GetPaisRequest request) {
        GetPaisResponse response = new GetPaisResponse();
        response.setPais(paisRepository.buscarPorPais(request.getNome()));

        return response;
    }
}