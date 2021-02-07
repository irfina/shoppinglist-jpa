/**
 * DaftarBelanjaDetil.java
 *
 * Created on Jan 25, 2021, 2:07:43 PM
 */
package shoppinglist.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author irfin
 */
@Entity
@Table(name = "daftarbelanjadetil")
public class DaftarBelanjaDetil 
{
    @EmbeddedId
    private DaftarBelanjaDetilId id;
    
    @MapsId("daftarbelanja_id")
    @ManyToOne
    @JoinColumn(name = "daftarbelanja_id")
    private DaftarBelanja induk;
    
    @Transient
    private int noUrut;
    
    @Column
    private String namaBarang;
    
    @Column(name = "jml")
    private float byk;
    
    @Column
    private String satuan;
    
    @Column
    private String memo;

    public DaftarBelanjaDetil()
    {
        id = new DaftarBelanjaDetilId();
    }
    
    public DaftarBelanja getInduk()
    {
        return induk;
    }
    
    public void setInduk(DaftarBelanja db)
    {
        induk = db;
    }

    public int getNoUrut()
    {
        return noUrut;
    }

    public void setNoUrut(int _noUrut)
    {
        noUrut = _noUrut;
        id.setNoUrut(noUrut);
    }

    public String getNamaBarang()
    {
        return namaBarang;
    }

    public void setNamaBarang(String _namaBarang)
    {
        this.namaBarang = _namaBarang;
    }

    public float getByk()
    {
        return byk;
    }

    public void setByk(float _byk)
    {
        this.byk = _byk;
    }

    public String getSatuan()
    {
        return satuan;
    }

    public void setSatuan(String _satuan)
    {
        this.satuan = _satuan;
    }

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String _memo)
    {
        this.memo = _memo;
    }
}
