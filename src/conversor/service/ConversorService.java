package conversor.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conversor.excecao.MoedaInvalidaException;
import conversor.model.ExchangeRateResponse;
import conversor.model.Usuario;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorService {
    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .setPrettyPrinting()
            .create();

    public double converter(Usuario usuario) throws Exception {
        String url = "https://v6.exchangerate-api.com/v6/2b18a6d0e8911e996748b80f/latest/" + usuario.getMoedaOrigem();

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ExchangeRateResponse exchange = gson.fromJson(json, ExchangeRateResponse.class);

        Double taxa = exchange.conversion_rates().get(usuario.getMoedaDestino());

        if (taxa == null) {
            throw new MoedaInvalidaException("Código de moeda inválido!");
        }

        return usuario.getValor() * taxa;
    }
}
