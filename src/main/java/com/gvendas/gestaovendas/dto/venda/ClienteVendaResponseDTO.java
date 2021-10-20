package com.gvendas.gestaovendas.dto.venda;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente da venda retorno DTO")
public class ClienteVendaResponseDTO {

	@ApiModelProperty(value = "Nome cliente")
	private String nome;

	@ApiModelProperty(value = "Venda")
	private List<VendaResponseDTO> vendasResponseDTOs;

	public ClienteVendaResponseDTO(String nome, List<VendaResponseDTO> vendasResponseDTOs) {
		this.nome = nome;
		this.vendasResponseDTOs = vendasResponseDTOs;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VendaResponseDTO> getVendasResponseDTOs() {
		return vendasResponseDTOs;
	}

	public void setVendasResponseDTOs(List<VendaResponseDTO> vendasResponseDTOs) {
		this.vendasResponseDTOs = vendasResponseDTOs;
	}

}
