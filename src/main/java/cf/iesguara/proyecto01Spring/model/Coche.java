package cf.iesguara.proyecto01Spring.model;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "coche")
public class Coche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, name = "modelo")
	private String model;

	@Column(unique = true, name = "codigo")
	private long code;

	@Column(name = "fecha_lanzamiento")
	private Date launchDate;

	@Column(nullable = false, name = "descontinuado")
	private Boolean discontinued;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabricante_id", referencedColumnName = "id")
	@JsonIgnoreProperties("coches")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Fabricante fabricante;

}
