package com.devops.dxc.devops.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.devops.dxc.devops.model.Dxc;
import com.devops.dxc.devops.model.RespuestaUfDTO;
import com.devops.dxc.devops.model.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/rest/msdxc")
public class RestData {

    private final static Logger LOGGER = Logger.getLogger("devops.subnivel.Control");

    @GetMapping(path = "/dxc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Dxc getData(@RequestParam(name = "sueldo") String sueldo, @RequestParam(name = "ahorro") String ahorro) {

        LOGGER.log(Level.INFO, "< Trabajo DevOps - DXC > <Consultado Diez por ciento> Sueldo: " + sueldo + ", Ahorro: " + ahorro);
        try {
            if (Integer.parseInt(ahorro) > 0 && !(Integer.parseInt(sueldo) < 0)) {
                Dxc response = new Dxc(Integer.parseInt(ahorro), Integer.parseInt(sueldo));
                response.calculaRetiro();
                 LOGGER.log(Level.INFO, "Response: " + response);
                return response;
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ahorro debe ser mayor que cero y sueldo mayor o igual a cero");
            }
        } catch (NumberFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingrese números en campos sueldo y ahorro", e);
		}
    }

    @GetMapping(path = "/uf", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    RespuestaUfDTO getData(@RequestParam(required = false) String fecha) {
        LOGGER.log(Level.INFO, "< Trabajo DevOps - DXC > <Consultado valor UF>");
        return Util.getUf(fecha);
    }
}
