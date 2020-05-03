package com.aerospace.university.matlab_executor.controller;

import com.aerospace.university.matlab_executor.model.Fdtd1Darguments;
import com.aerospace.university.matlab_executor.model.Fdtd2Darguments;
import com.aerospace.university.matlab_executor.model.Fdtd3Darguments;
import com.aerospace.university.matlab_executor.service.FdtdExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class FdtdViewController {

    private final FdtdExecutorService fdtdExecutorService;

    @Autowired
    public FdtdViewController(FdtdExecutorService fdtdExecutorService) {
        this.fdtdExecutorService = fdtdExecutorService;
    }

    @GetMapping({"/fdtd_1D"})
    public String getFdtd1D() {
        return "fdtd1dView";
    }

    @GetMapping({"/fdtd_2D"})
    public String getFdtd2D() {
        return "fdtd2dView";
    }

    @GetMapping({"/fdtd_3D"})
    public String getFdtd3D() {
        return "fdtd3dView";
    }

    @PostMapping({"/calculateFdtd_1D"})
    public void calculateFdtd1D(@RequestParam("Lambda") String Lambda,
                                @RequestParam("Q") String Q,
                                @RequestParam("Qt") String Qt,
                                @RequestParam("QT") String QT,
                                @RequestParam("Eps") String Eps,
                                @RequestParam("LzConst") String LzConst) throws IOException {
        Fdtd1Darguments fdtd1Darguments = new Fdtd1Darguments(Lambda, Q, Qt, QT, Eps, LzConst);
        this.fdtdExecutorService.executeFdtd1d(fdtd1Darguments);
    }

    @PostMapping({"/calculateFdtd_2D"})
    public void calculateFdtd2D(@RequestParam("Lambda") String Lambda,
                                @RequestParam("Q") String Q,
                                @RequestParam("Qt") String Qt,
                                @RequestParam("QT") String QT,
                                @RequestParam("Eps") String Eps,
                                @RequestParam("LzConst") String LyConst,
                                @RequestParam("LzConst") String LzConst) throws IOException {
        Fdtd2Darguments fdtd2Darguments = new Fdtd2Darguments(Lambda, Q, Qt, QT, Eps, LyConst, LzConst);
        this.fdtdExecutorService.executeFdtd2d(fdtd2Darguments);
    }

    @PostMapping({"/calculateFdtd_3D"})
    public void calculateFdtd3D(@RequestParam("Lambda") String Lambda,
                                @RequestParam("Q") String Q,
                                @RequestParam("Qt") String Qt,
                                @RequestParam("QT") String QT,
                                @RequestParam("Eps") String Eps,
                                @RequestParam("LzConst") String LxConst,
                                @RequestParam("LzConst") String LyConst,
                                @RequestParam("LzConst") String LzConst) throws IOException {
        Fdtd3Darguments fdtd3Darguments = new Fdtd3Darguments(Lambda, Q, Qt, QT, Eps, LxConst, LyConst, LzConst);
        this.fdtdExecutorService.executeFdtd3d(fdtd3Darguments);
    }

}