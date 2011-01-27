package finance.and.investment;

import java.math.*;

public class Investition
{
	// Members.
	//
	protected static final int Scale = 2;
	private BigDecimal abschreibung = null;
	private BigDecimal betrag = null;
	private BigDecimal nutzungsdauer = null;
	private BigDecimal restwert = null;
	
	// Construction.
	//	
	public Investition(String betrag, String nutzungsdauer, String restwert)
	{
		this(new BigDecimal(betrag), new BigDecimal(nutzungsdauer), new BigDecimal(restwert));
	}
	
	public Investition(BigDecimal betrag, BigDecimal nutzungsdauer, BigDecimal restwert)
	{
		this.betrag = betrag;
		this.nutzungsdauer = nutzungsdauer;
		this.restwert = restwert;
		
		this.abschreibung = this.betrag.subtract(this.restwert).divide(this.nutzungsdauer).setScale(Investition.Scale);
	}
	
	// Properties.
	//
	public BigDecimal getAbschreibung()
	{ return this.abschreibung.setScale(Investition.Scale); }
	
	public BigDecimal getBetrag()
	{ return this.betrag.setScale(Investition.Scale); }
	
	public BigDecimal getNutzungsdauer()
	{ return this.nutzungsdauer.setScale(Investition.Scale); }
	
	public BigDecimal getRestwert()
	{ return this.restwert.setScale(Investition.Scale); }
	
	// Methods.
	//
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Investition:\t" + this.getBetrag() + "\n");
		buffer.append("Nutzungsdauer:\t" + this.getNutzungsdauer() + "\n");
		buffer.append("Restwert:\t" + this.getRestwert() + "\n");
		buffer.append("Abschreibung:\t" + this.getAbschreibung() + "\n");
		
		return buffer.toString();
	}
}
