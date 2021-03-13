package com.luizcdev.ilockeractuator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizcdev.ilockeractuator.dto.ResponseBodyDTO;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;

@RestController
public class LockerAccessController {
	
	@PostMapping("/unlock/{uuid}")
    public ResponseEntity<ResponseBodyDTO<String>> postUnlock(@PathVariable(name = "uuid") final String uuid) {
		
		GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "locker", PinState.HIGH);
		
		pin.toggle();
		
		ResponseBodyDTO<String> body = new ResponseBodyDTO<>("Sucesso");
        return new ResponseEntity<>(body, HttpStatus.OK);
                
    }	

}
