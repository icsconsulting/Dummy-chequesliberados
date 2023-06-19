package com.bdv.microservicios.Dummychquesliberados.model.repository;


import com.bdv.microservicios.Dummychquesliberados.model.entity.Cheque;
import com.bdv.microservicios.Dummychquesliberados.model.entity.ChequeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ChequeRepo extends JpaRepository<Cheque, ChequeId> {
    @Query(value= """
                       SELECT u FROM TBL_CHEQUES u 
                        WHERE u.estatus=?1 
                        AND u.agencia=?2""")
    List<Cheque> findByEstatusAndAgencia(String estatus, String agencia);
}
