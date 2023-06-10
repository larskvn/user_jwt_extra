package com.usersmartheal.feignClients;


import com.usersmartheal.Model.Valoracion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "valoracion-service", url = "http://localhost:8004")
public interface ValoracionFeignClient {

    @PostMapping("/valoracion")
   Valoracion add(@RequestBody Valoracion valoracion);


}
