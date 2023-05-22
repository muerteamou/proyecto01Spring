package cf.iesguara.proyecto01Spring.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Fabricante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, unique = true, name = "nombre")
	private String name;

	@Column(nullable = false, name = "pais")
	private String country;

	@Column(name = "ventas_anuales")
	private Long sales;

	@Column(name = "fecha_creacion")
	private Date createDate;

	@Column(nullable = false, name = "activa")
	private Boolean active;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabricante_id")
	@JsonIgnoreProperties("fabricante")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Coche> coches;
}
