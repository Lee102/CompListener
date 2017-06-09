/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Workstation;
import entity.WorkstationAdditionalData;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import service.WorkstationAdditionalDataService;
import service.WorkstationService;

/**
 *
 * @author Łukasz Wojtas
 */
public class WorkstationInfo {

    private static Workstation workstation;

    public static int sendWorkstation() {
        try {
            if (System.getenv().containsKey("COMPUTERNAME")) {
                workstation = WorkstationService.findByComputerName(System.getenv().get("COMPUTERNAME"));
            }
            if (workstation == null && System.getenv().containsKey("HOSTNAME")) {
                workstation = WorkstationService.findByUserDomain(System.getenv().get("USERDOMAIN"));
            }
            if (workstation == null && System.getenv().containsKey("USERNAME")) {
                workstation = WorkstationService.findByUserName(System.getenv().get("USERNAME"));
            }
            if (workstation == null) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
                    workstation = WorkstationService.findByMACAddress(networkInterface.getHardwareAddress());
                } catch (SocketException | UnknownHostException e) {
                    System.out.println(e.toString());
                }
            }
            if (workstation == null) {
                workstation = new Workstation();
                if (System.getenv().containsKey("COMPUTERNAME")) {
                    workstation.setComputerName(System.getenv().get("COMPUTERNAME"));
                } else {
                    workstation.setComputerName("UNKNOWN COMPUTER");
                }
                if (System.getenv().containsKey("USERDOMAIN")) {
                    workstation.setUserDomain(System.getenv().get("USERDOMAIN"));
                }
                if (System.getenv().containsKey("USERNAME")) {
                    workstation.setUserName(System.getenv().get("USERNAME"));
                }
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
                    workstation.setMacAddress(networkInterface.getHardwareAddress());
                } catch (SocketException | UnknownHostException e) {
                    System.out.println(e.toString());
                }
                WorkstationService.save(workstation);
                sendWorkstationAdditionalData();
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e.toString());
            return 1;
        }
    }

    private static void sendWorkstationAdditionalData() {
        WorkstationAdditionalData workstationAdditionalData = new WorkstationAdditionalData();
        Long p;

        workstationAdditionalData.setWorkstationId(workstation);
        workstationAdditionalData.setOsVersion(System.getProperty("os.name"));
        workstationAdditionalData.setOsArch(System.getProperty("os.arch"));
        workstationAdditionalData.setJavaVersion(System.getProperty("java.version"));
        workstationAdditionalData.setProcId(System.getenv("PROCESSOR_IDENTIFIER"));
        workstationAdditionalData.setProcArch(System.getenv("PROCESSOR_ARCHITECTURE"));
        workstationAdditionalData.setProcCores(Runtime.getRuntime().availableProcessors());
        p = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize() / 1024 / 1024 / 1024;
        workstationAdditionalData.setRamSize(p.intValue());
        p = new File("/").getTotalSpace() / 1024 / 1024 / 1024;
        workstationAdditionalData.setDiskSize(p.intValue());

        WorkstationAdditionalDataService.save(workstationAdditionalData);
    }

    public static Workstation getWorkstation() {
        return workstation;
    }

    public static void setWorkstation(Workstation workstation) {
        WorkstationInfo.workstation = workstation;
    }

}
