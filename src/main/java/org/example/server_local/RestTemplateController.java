package org.example.server_local;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {

    @GetMapping("/get_cell_info")
    public Object getCellInfo(@RequestParam(name = "sothuebao") String soThueBao) {
        System.out.println(soThueBao);
        return "View cell: " + soThueBao;
    }
}
