package com.bdv.microservicios.Dummychquesliberados.services;


import com.bdv.microservicios.Dummychquesliberados.model.entity.Cheque;
import com.bdv.microservicios.Dummychquesliberados.model.entity.ChequeId;

import java.util.List;
import java.util.Optional;

public interface ChequeService {
    List<Cheque> consultarChequesEstatusAgencia(String estatus, String agencia);
    List<Cheque> consultarChequesAgencia(String agencia);
    Optional<Cheque> consultarChequePorId(ChequeId chequeId);
    Optional<Cheque> actualizarestatuscheque(ChequeId chequeId,String nuevoEstatus);
}
