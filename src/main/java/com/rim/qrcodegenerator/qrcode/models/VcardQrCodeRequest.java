package com.rim.qrcodegenerator.qrcode.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class VcardQrCodeRequest {


    private String nom;

    private String prenom;

    private String telephone;

    private String email;
    private String siteInternet;
    private String entreprise;

}
