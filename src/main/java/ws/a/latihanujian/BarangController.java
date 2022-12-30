/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.latihanujian;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fuadi
 */
@Controller
@ResponseBody
public class BarangController {
    Barang data = new Barang();
    BarangJpaController bctrl = new BarangJpaController();
    
    @RequestMapping ("/getBarang")
    public String getBarang(){
        bctrl.findBarangEntities();
        return data.getId()+ "<br>" + data.getNama()+ "<br>" + data.getJumlah();
    }
    
    @RequestMapping ("/getBarang/{id}")
    public String getBarang(@PathVariable("id")int id){
        try {
            data = bctrl.findBarang(id);
            return "Nama Barang = " + data.getNama()+ "<br>" + "Jumlah Barang = " + data.getJumlah();
        }
        catch (Exception Error){return "Data tidak ada";}
    }
    
    @RequestMapping ("/deleteBarang/{id}")
    public String deleteData(@PathVariable("id")int id){
        try {
            bctrl.destroy(id);
            return "id " + id + " Deleted";
        }
        catch (Exception Error){return "id " + id + " tidak ada";}
    }
}
