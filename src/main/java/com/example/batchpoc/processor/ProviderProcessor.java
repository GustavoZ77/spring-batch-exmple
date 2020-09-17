package com.example.batchpoc.processor;

import com.example.batchpoc.domain.Provider;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service("providerProcessor")
public class ProviderProcessor implements ItemProcessor<Provider, Provider> {


    @Override
    public Provider process(Provider provider) throws Exception {

        Provider providerTransformed = provider;
        providerTransformed.setLastName(provider.getLastName().toUpperCase());
        providerTransformed.setFirstName(provider.getFirstName().toUpperCase());


    return providerTransformed;
    }
}
