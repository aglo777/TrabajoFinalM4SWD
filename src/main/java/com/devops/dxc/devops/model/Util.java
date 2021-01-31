package com.devops.dxc.devops.model;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;

public class Util {

    /**
     * Método para cacular el 10% del ahorro en la AFP.  Las reglas de negocio se pueden conocer en 
     * https://www.previsionsocial.gob.cl/sps/preguntas-frecuentes-nuevo-retiro-seguro-10/
     * @param dxc
     * @return Cálculo 10% ahorro AFP
     */
    public static void calcula10(Dxc dxc) {
        double valorUf = getUf().getSerie()[0].getValor();
        if (dxc.getAhorro() <= valorUf * 35) {
            dxc.setImpuesto(calculaImpuesto(dxc));
            dxc.setSaldo(0.0);
            dxc.setRetiro(dxc.getAhorro());
        } else {
            dxc.setImpuesto(calculaImpuesto(dxc));
            double ahorro = dxc.getAhorro();
            double impuesto = Double.parseDouble(dxc.getImpuesto());
            double diezPorciento = ahorro * 0.1 - impuesto;
            dxc.setRetiro(Math.min(diezPorciento, valorUf * 150));
            dxc.setSaldo(dxc.getAhorro() - diezPorciento);
        }
    }

    public static double calculaImpuesto(Dxc dxc){
        if(dxc.getSueldo() < 1500000){
            return 0;
        }else if(dxc.getSueldo() >= 1500000 && dxc.getSueldo() < 2500000){
            return 174531;
        }else if(dxc.getSueldo() >= 2500000 && dxc.getSueldo() < 3000000){
            return 364086;
        }else if(dxc.getSueldo() >= 3000000 && dxc.getSueldo() < 4000000){
            return 612396;
        }else if(dxc.getSueldo() >= 4000000 && dxc.getSueldo() < 5000000){
            return 980357;
        }else if(dxc.getSueldo() >= 5000000 && dxc.getSueldo() < 6000000){
            return 1294052;
        }else{
            return 1491042;
        }
    }

        /**
         * Método que retorna el valor de la UF
         * @return uf
         */
    public static RespuestaUfDTO getUf(){
        String uri = "https://mindicador.cl/api/uf";

        RestTemplate restTemplate = new RestTemplate();

        String json = restTemplate.getForObject(uri, String.class);
        RespuestaUfDTO respuestaUfDTO = new Gson().fromJson(json, RespuestaUfDTO.class);
        return respuestaUfDTO;

    }
    
}
