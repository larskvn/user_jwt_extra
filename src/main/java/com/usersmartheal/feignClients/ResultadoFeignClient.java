package com.usersmartheal.feignClients;


import com.usersmartheal.Model.Resultados;
import com.usersmartheal.Model.Valoracion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "resultado-service", url = "http://localhost:8002")
public interface ResultadoFeignClient {



    @PostMapping("/resultado")
    Resultados add(@RequestBody Resultados r);

    @GetMapping("/byuser/{idUser}")
    List<Resultados> getResult(@PathVariable ("idUser") int idUser);


}
