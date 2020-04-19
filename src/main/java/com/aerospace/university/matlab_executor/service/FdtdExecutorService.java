package com.aerospace.university.matlab_executor.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FdtdExecutorService {

    private String matlabPath = "D:\\MatLab\\bin\\win64\\MATLAB.exe";
    private String scriptFolderPath = "C:\\Users\\Zufar\\Desktop\\script";
    private String fdtd1D = "fdtd1D.m";
    private String fdtd2D = "fdtd2D.m";
    private String fdtd3D = "fdtd3D.m";


    public void executeFdtd1d() throws IOException {
        execute(fdtd1D);
    }

    public void executeFdtd2d() throws IOException {
        execute(fdtd2D);
    }

    public void executeFdtd3d() throws IOException {
        execute(fdtd3D);
    }

    private void execute(String program) throws IOException {
        String command = String.format("%s -nodisplay -nosplash -nodesktop -r \"run('%s\\%s');\"", matlabPath, scriptFolderPath, program);
        Runtime run = Runtime.getRuntime();
        run.exec(command);
    }
}
