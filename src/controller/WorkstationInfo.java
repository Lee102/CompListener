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
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
                byte[] macAddress = networkInterface.getHardwareAddress();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < macAddress.length; i++) {
                    stringBuilder.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
                }
                workstation = WorkstationService.findByAll(System.getenv().get("COMPUTERNAME"), System.getenv().get("USERDOMAIN"), System.getenv().get("USERNAME"), stringBuilder.toString());
                if (workstation == null) {
                    workstation = new Workstation();
                    workstation.setComputerName(System.getenv().get("COMPUTERNAME"));
                    workstation.setUserDomain(System.getenv().get("USERDOMAIN"));
                    workstation.setUserName(System.getenv().get("USERNAME"));
                    workstation.setMacAddress(stringBuilder.toString());
                    WorkstationService.save(workstation);
                    sendWorkstationAdditionalData();
                }
            } catch (SocketException | UnknownHostException e) {
                System.out.println(e.toString());
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
