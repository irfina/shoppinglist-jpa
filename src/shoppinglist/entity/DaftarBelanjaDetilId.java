/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinglist.entity;

import javax.persistence.Embeddable;

/**
 *
 * @author irfin
 */
@Embeddable
public class DaftarBelanjaDetilId
{
    private long daftarbelanja_id;
    private int nourut;

    public long getDaftarBelanjaId()
    {
        return daftarbelanja_id;
    }

    public void setDaftarBelanjaId(long daftarbelanja_id)
    {
        this.daftarbelanja_id = daftarbelanja_id;
    }

    public int getNoUrut()
    {
        return nourut;
    }

    public void setNoUrut(int nourut)
    {
        this.nourut = nourut;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 67 * hash + (int) (this.daftarbelanja_id ^ (this.daftarbelanja_id >>> 32));
        hash = 67 * hash + this.nourut;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DaftarBelanjaDetilId other = (DaftarBelanjaDetilId) obj;
        if (this.daftarbelanja_id != other.daftarbelanja_id) {
            return false;
        }
        if (this.nourut != other.nourut) {
            return false;
        }
        return true;
    }    
}
