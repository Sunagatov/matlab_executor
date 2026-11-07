# MATLAB FDTD Executor

A Spring Boot web interface for launching MATLAB finite-difference time-domain electromagnetic simulations.

<p>
  <a href="https://buymeacoffee.com/lucky_1uck">
    <img src="https://img.shields.io/badge/Support_the_project-FFDD00?style=for-the-badge&amp;logo=buymeacoffee&amp;logoColor=black" alt="Support the project" width="260" height="40">
  </a>
</p>

## What is included

- Parameter forms for 1D, 2D and 3D FDTD simulations.
- MATLAB scripts implementing field calculations and plots.
- A Java service that prepares a script and launches the MATLAB executable.

## Stack

Java 8 · Spring Boot 2.2 · FreeMarker · Maven · MATLAB

## Local setup

Install JDK 8, Maven and a working licensed MATLAB installation. Configure these
properties for your machine:

| Property | Purpose |
| --- | --- |
| `matlabPath` | Path to the MATLAB executable |
| `fdtdScriptsPath` | Writable scripts directory, including its trailing path separator |
| `fdtdScripts.1d`, `.2d`, `.3d` | Names of the corresponding MATLAB script files |

The supplied executable path is Windows-specific. Change it before launching
on another installation. The service writes `calculateFdtd.m` into the scripts
directory before starting MATLAB.

```bash
mvn package
mvn spring-boot:run
```

Open `http://localhost:8080/fdtd_1D`, `/fdtd_2D` or `/fdtd_3D`.

## Code map

- [Java application](src/main/java/com/aerospace/university/matlab_executor): controllers, parameter models and execution services.
- [Templates](src/main/resources/templates): simulation input forms.
- [MATLAB scripts](src/main/resources/scripts): numerical implementations.

## Current limits

The Java layer launches MATLAB as an external process; it does not return a
completed simulation result through a job API. Runs also share the generated
`calculateFdtd.m` file, so concurrent jobs are not isolated. The 3D Java command
and MATLAB function have different argument lists; reconcile them before
depending on the 3D form.

## ☕ Support the project

If this project helps you learn or build, you can support its development.

<p>
  <a href="https://buymeacoffee.com/lucky_1uck">
    <img src="https://img.shields.io/badge/Support_the_project-FFDD00?style=for-the-badge&amp;logo=buymeacoffee&amp;logoColor=black" alt="Support the project" width="260" height="40">
  </a>
</p>
