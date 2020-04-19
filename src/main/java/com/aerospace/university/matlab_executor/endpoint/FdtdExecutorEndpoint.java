package com.aerospace.university.matlab_executor.endpoint;

import com.aerospace.university.matlab_executor.service.FdtdExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class FdtdExecutorEndpoint {

    private final  FdtdExecutorService fdtdExecutorService;

    @Autowired
    public FdtdExecutorEndpoint(FdtdExecutorService fdtdExecutorService) {
        this.fdtdExecutorService = fdtdExecutorService;
    }

    @GetMapping("/fdtd1D")
    public void executeFDTD1D() throws IOException {
        this.fdtdExecutorService.executeFdtd1d();
    }

    @GetMapping("/fdtd2D")
    public void executeFDTD2D() throws IOException {
        this.fdtdExecutorService.executeFdtd1d();
    }

    @GetMapping("/fdtd3D")
    public void executeFDTD3D() throws IOException {
        this.fdtdExecutorService.executeFdtd1d();
    }
}
