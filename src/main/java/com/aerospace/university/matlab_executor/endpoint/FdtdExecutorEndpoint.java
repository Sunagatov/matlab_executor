package com.aerospace.university.matlab_executor.endpoint;

import com.aerospace.university.matlab_executor.model.Fdtd1Darguments;
import com.aerospace.university.matlab_executor.model.Fdtd2Darguments;
import com.aerospace.university.matlab_executor.model.Fdtd3Darguments;
import com.aerospace.university.matlab_executor.service.FdtdExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class FdtdExecutorEndpoint {

    private final FdtdExecutorService fdtdExecutorService;

    @Autowired
    public FdtdExecutorEndpoint(FdtdExecutorService fdtdExecutorService) {
        this.fdtdExecutorService = fdtdExecutorService;
    }

    @PostMapping("/fdtd1D")
    public void executeFDTD1D(@RequestBody Fdtd1Darguments fdtd1Darguments) throws IOException {
        this.fdtdExecutorService.executeFdtd1d(fdtd1Darguments);
    }

    @PostMapping("/fdtd2D")
    public void executeFDTD2D(@RequestBody Fdtd2Darguments fdtd2Darguments) throws IOException {
        this.fdtdExecutorService.executeFdtd2d(fdtd2Darguments);
    }

    @PostMapping("/fdtd3D")
    public void executeFDTD3D(@RequestBody Fdtd3Darguments fdtd3Darguments) throws IOException {
        this.fdtdExecutorService.executeFdtd3d(fdtd3Darguments);
    }
}