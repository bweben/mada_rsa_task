package li.naw.rsa;

import li.naw.rsa.decode.Decoder;
import li.naw.rsa.encode.Encoder;
import li.naw.rsa.generate.Generator;
import li.naw.rsa.model.RSAKeys;
import li.naw.rsa.model.RSAPrivateKey;
import li.naw.rsa.model.RSAPublicKey;
import li.naw.rsa.utils.FileReader;
import li.naw.rsa.utils.FileToPrivateKey;
import li.naw.rsa.utils.FileToPublicKey;
import li.naw.rsa.utils.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();
        // app.generateKeyPair();
        // app.encodeText();
        // app.decodeText();
        // app.decodeFileAndLog();
    }

    // generate RSA key pair and save it
    private void generateKeyPair() throws IOException {
        RSAKeys RSAKeyPair = new Generator().generateRSAKeys();
        new FileWriter(RSAKeyPair.getPrivateKey()).writeToFile();
        new FileWriter(RSAKeyPair.getPublicKey()).writeToFile();
    }

    // encode text and save as chiffre.txt
    private void encodeText() throws IOException {
        String text = new FileReader().readAsString("text.txt");
        RSAPublicKey publicKey = new FileToPublicKey("pk.txt").loadPublicKey();

        String encodedText = new Encoder(publicKey).encode(text);

        Files.writeString(Path.of("chiffre.txt"), encodedText);
    }

    // decode text and save as text-d.txt
    private void decodeText() throws IOException {
        String encodedText = new FileReader().readAsString("chiffre.txt");
        RSAPrivateKey privateKey = new FileToPrivateKey("sk.txt").loadPrivateKey();

        String text = new Decoder(privateKey).decode(encodedText);

        Files.writeString(Path.of("text-d.txt"), text);
    }

    // decode text from chiffre.txt and log to console
    private void decodeFileAndLog() throws IOException {
        String encodedText = new FileReader().readAsString("chiffre.txt");
        RSAPrivateKey privateKey = new FileToPrivateKey("sk.txt").loadPrivateKey();

        String text = new Decoder(privateKey).decode(encodedText);
        System.out.println(text);
    }
}
