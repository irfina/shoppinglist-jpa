/**
 * DaftarBelanja.java
 *
 * Created on Jan 25, 2021, 2:04:41 PM
 */
package shoppinglist.entity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author irfin
 */
@Entity
@Table(name = "daftarbelanja")
public class DaftarBelanja 
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "daftarbelanja_id_seq")
    @SequenceGenerator(name = "daftarbelanja_id_seq", sequenceName = "daftarbelanja_id_seq", allocationSize = 1)
    private long id;
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime tanggal;
    
    @Column
    private String judul;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "daftarbelanja_id")
    private List<DaftarBelanjaDetil> daftarBrg;

    public DaftarBelanja()
    {
        daftarBrg = new LinkedList<>();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long _id)
    {
        this.id = _id;
    }

    public LocalDateTime getTanggal()
    {
        return tanggal;
    }

    public void setTanggal(LocalDateTime _tanggal)
    {
        this.tanggal = _tanggal;
    }

    public String getJudul()
    {
        return judul;
    }

    public void setJudul(String _judul)
    {
        this.judul = _judul;
    }

    public List<DaftarBelanjaDetil> getDaftarBarang()
    {
        return daftarBrg;
    }
    
    public void addDaftarBarang(DaftarBelanjaDetil _brg)
    {
        daftarBrg.add(_brg);
        _brg.setInduk(this);
    }

    public void setDaftarBarang(List<DaftarBelanjaDetil> _daftarBrg)
    {
        this.daftarBrg = _daftarBrg;
        for (int i = 0; i < daftarBrg.size(); i++)
            daftarBrg.get(i).setInduk(this);
    }
}
