package fr.s2re.impl.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import fr.s2re.banque.api.business.IDeviseBusiness;
import fr.s2re.banque.dto.DeviseDto;

@Path("/deviseService")
@Produces("application/json")
public class ServiceDeviseWebServiceImp {

    private static final Logger LOGGER = Logger.getLogger(ServiceDeviseWebServiceImp.class);

    @EJB
    IDeviseBusiness deviseBusiness;

    /**
     * http://localhost:8080/Banque-WebService-0.0.1-SNAPSHOT/services/rest/deviseService/devise/EUR
     * @param code
     * @return
     */
    @GET
    @Path("/devise/{code}")
    public DeviseDto rechercherDeviseParCode(String code) {
        return deviseBusiness.rechercherDeviseParCode(code);

    }

    /**
     * fin d'URL en convert?amount=50&scr=EUR&target=USD
     * @param amount
     * @param src
     * @param target
     * @return
     */
    @GET
    @Path("/convert")
    @Produces("text/plain")
    public double convertir(Double amount, String src, String target) {
        return deviseBusiness.convertir(amount, src, target);

    }

    @PUT
    @Path("/devise")
    @Consumes("application/json")
    public DeviseDto updateDevise(DeviseDto dev) {
        return deviseBusiness.updateDevise(dev);

    }

    /**
     * fin URL en deviseService/devise ou bien deviseService/devise?changeMini=1&param2=val2
     * @param changeMini
     * @return
     */
    @GET
    @Path("/devise")
    public List<DeviseDto> rechercherDevises(Double changeMini) {
        return deviseBusiness.rechercherDevises(changeMini);

    }

}
