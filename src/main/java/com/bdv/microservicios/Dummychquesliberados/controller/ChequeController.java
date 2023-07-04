package com.bdv.microservicios.Dummychquesliberados.controller;

import com.bdv.microservicios.Dummychquesliberados.model.dto.Chequedto;
import com.bdv.microservicios.Dummychquesliberados.model.entity.Cheque;
import com.bdv.microservicios.Dummychquesliberados.model.entity.ChequeId;
import com.bdv.microservicios.Dummychquesliberados.model.mappers.ChequeToChequedtoMapper;
import com.bdv.microservicios.Dummychquesliberados.services.ChequeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("app/cheques")
public class ChequeController {
    private final ChequeService chequeService;
    List<Cheque> cheques;


    public ChequeController(ChequeService chequeService) {
        this.chequeService = chequeService;
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Chequedto>> consultarcheques(@RequestParam(required = false) String estatus,@RequestParam String agencia){

        ResponseEntity<List<Chequedto>> response;
        if(estatus!=null) {
             cheques = chequeService.consultarChequesEstatusAgencia(estatus.trim(), agencia);
        }else{
            cheques = chequeService.consultarChequesAgencia(agencia);
        }


        List<Chequedto> chequedtos=cheques.stream().map(cheque ->
                new ChequeToChequedtoMapper().apply(cheque)).collect(Collectors.toList());

        if (!cheques.isEmpty()){
            response=new ResponseEntity<>(chequedtos, HttpStatus.OK);
        }else{
            response=ResponseEntity.notFound().build();
        }

        return response;
    }

    @PostMapping("modificar/{nuevoestatus}")
    public ResponseEntity<Chequedto> actualizarestatuscheque(@RequestBody ChequeId chequeId,@PathVariable String nuevoestatus){
        Optional<Cheque> chequeactualizado;
        if(chequeId!=null){
            //estatus=X
           //   ChequeId chequeGuardadoId=new ChequeId("42373791","0102","0040","46","0400249540");
            //estatus=P
           //  ChequeId chequeGuardadoId2=new ChequeId("08607487","0108","0030","72","0100040968");
           // Optional<Cheque> optionalCheque=chequeService.consultarChequePorId(chequeId);
            if ((chequeId.getSerial().equals("42373791")&&chequeId.getBanco().equals("0102")
                    &&chequeId.getOficina().equals("0040")&&chequeId.getDv().equals("46")&&chequeId.getCuenta().equals("0400249540"))
            ||(chequeId.getSerial().equals("08607487")&&chequeId.getBanco().equals("0102")
                    &&chequeId.getOficina().equals("0030")&&chequeId.getDv().equals("72")&&chequeId.getCuenta().equals("0100040968"))){
                chequeactualizado=chequeService.actualizarestatuscheque(chequeId,nuevoestatus);
                return new ResponseEntity<>(new ChequeToChequedtoMapper().apply(chequeactualizado.get()),HttpStatus.OK);
            }else{
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.badRequest().build();
        }


    }

}
