package com.rim.qrcodegenerator;

import com.rim.qrcodegenerator.qrcode.QrCodeService;
import com.rim.qrcodegenerator.qrcode.models.QrCodeRequest;
import com.rim.qrcodegenerator.qrcode.models.QrCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class IndexController {

    private static final String CONTENT_TYPE_TURBO_STREAM="text/vnd.turbo-stream.html";

    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping(value = {"/","index"})
    public String index(Model model){
        model.addAttribute("qrCodeRequest", new QrCodeRequest());
        model.addAttribute("qrCodeResponse",new QrCodeResponse());
        return "index";
    }

    @PostMapping(value = "generateQrCode")
    public String generateQrCode(@ModelAttribute @Valid QrCodeRequest qrCodeRequest, Model model)  {
        QrCodeResponse qrCodeResponse = qrCodeService.generateQrCode(qrCodeRequest);
        model.addAttribute("qrCodeResponse",qrCodeResponse);
        return "index";
    }

}
