package com.globant.courier.glober.domain.usecases;

import com.globant.courier.glober.domain.ports.services.IExampleService;
import org.springframework.stereotype.Service;

@Service
public class ExampleService implements IExampleService {

    @Override
    public String guessNumber(int expectedNum, int guessedNum) {

        if(expectedNum == guessedNum){
            return "ok";
        }else {
            return "fail";
        }

    }
}
