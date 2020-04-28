package com.aerospace.university.matlab_executor.service;

import com.aerospace.university.matlab_executor.model.Fdtd1Darguments;
import com.aerospace.university.matlab_executor.model.Fdtd2Darguments;
import com.aerospace.university.matlab_executor.model.Fdtd3Darguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FdtdExecutorService {

    private final FileHandlerService fileHandlerService;

    @Value("${matlabPath}")
    private String matlabPath;

    @Value("${scriptFolderPath}")
    private String scriptFolderPath;

    @Autowired
    public FdtdExecutorService(FileHandlerService fileHandlerService) {
        this.fileHandlerService = fileHandlerService;
    }

    public void executeFdtd1d(Fdtd1Darguments fdtd1Darguments) throws IOException {
        String fdtd1D = "Fdtd1d.m";
        String command = String.format("%s -nodisplay -nosplash -nodesktop -r \"cd('%s'); calculate%s(%s, %s, %s, %s, %s);\"",
                matlabPath, scriptFolderPath, fdtd1D, fdtd1Darguments.getLambda(), fdtd1Darguments.getQ(), fdtd1Darguments.getQt(), fdtd1Darguments.getQT(), fdtd1Darguments.getLzConst());
        this.execute(fdtd1D, command, fdtd1Darguments.getEps());
    }

    public void executeFdtd2d(Fdtd2Darguments fdtd2Darguments) throws IOException {
        String fdtd1D = "Fdtd2d.m";
        String command = String.format("%s -nodisplay -nosplash -nodesktop -r \"cd('%s'); calculate%s(%s, %s, %s, %s, %s, %s);\"",
                matlabPath, scriptFolderPath, fdtd1D,
                fdtd2Darguments.getLambda(), fdtd2Darguments.getQ(), fdtd2Darguments.getQt(), fdtd2Darguments.getQT(),
                fdtd2Darguments.getLyConst(), fdtd2Darguments.getLzConst());
        this.execute(fdtd1D, command, fdtd2Darguments.getEps());
    }

    public void executeFdtd3d(Fdtd3Darguments fdtd3Darguments) throws IOException {
        String fdtd3D = "Fdtd3d";
        String command = String.format("%s -nodisplay -nosplash -nodesktop -r \"cd('%s'); calculate%s(%s, %s, %s, %s, %s, %s);\"",
                matlabPath, scriptFolderPath, fdtd3D,
                fdtd3Darguments.getLambda(), fdtd3Darguments.getQ(), fdtd3Darguments.getQt(), fdtd3Darguments.getQT(),
                fdtd3Darguments.getLyConst(), fdtd3Darguments.getLzConst());
        this.execute(fdtd3D, command, fdtd3Darguments.getEps());
    }

    private void execute(String programName, String command, String eps) throws IOException {
        String textProgram = fileHandlerService.read(scriptFolderPath + "calculate" + programName);
        textProgram = fileHandlerService.replace(textProgram, "epsValue", eps);
        fileHandlerService.write(textProgram, scriptFolderPath + "newFile.m");
        Runtime run = Runtime.getRuntime();
        run.exec(command);
    }
}
