package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@SpringBootApplication
public class SslServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslServerApplication.class, args);
    }

    @RestController
    public static class MainController {

        @GetMapping("/")
        public String home() {
            return "Welcome to the SSL Server!";
        }

        @GetMapping("/checksum")
        public String getCheckSum(@RequestParam(value = "data", defaultValue = "Hello Janncy Mota!") String data) throws NoSuchAlgorithmException {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes());
            return String.format("<p>Data: %s</p><p>Algorithm: SHA-256</p><p>Checksum (Hex): %s</p>",
                                 data, HexFormat.of().formatHex(hash));
        }
    }
}
