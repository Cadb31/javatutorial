package com.agsnasoft.vaadin;

import java.util.List;

import org.vaadin.viritin.button.MButton;
import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.label.MLabel;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.agsnasoft.model.CabeceraRecibo;
import com.agsnasoft.model.Recibo;
import com.agsnasoft.model.ReciboDao;
import com.agsnasoft.model.ReciboDaoImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Title("Recibos")
@Theme("valo")
@SpringUI
public class Recibos extends UI {

	/**
	 *
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MLabel title = new MLabel("SELECCION DE RECIBOS");
	
	private Label ramo = new Label("Ramo:");
	private Label ramoDecription = new Label();
	
	private Label mutualista = new Label("Mutualista:");
	private Label mutualistaDecription = new Label();

	private Label oasegurado = new Label("O.Asegurado:");
	private Label oaseguradoDecription = new Label();
	
	private Label modalidad = new Label("Modalidad:");
	private Label modalidadDecription = new Label();
	
	private Label dirPago = new Label("Dir. Pago:");
	private Label dirPagoDecription = new Label();
	
	private Label nPoliza = new Label("N. Poliza:");
	private Label nPolizaDecription = new Label();
	
	private Label nif = new Label("NIF:");
	private Label nifDecription = new Label();

	private Label fecEfecto = new Label("Fec. Efecto:");
	private Label fecEfectoDecription = new Label();

	private Label franquicia = new Label("Franquicia:");
	private Label franquiciaDecription = new Label();

	private Label vencimiento = new Label("Vencimiento:");
	private Label vencimientoDecription = new Label();

	private Label ccc = new Label("CCC:");
	private Label cccDecription = new Label();

    private Button consultar = new MButton(FontAwesome.SEARCH, "Consultar", this::consultar);
    private Button historico = new MButton(FontAwesome.HISTORY, "Historico", this::verHistorico);
    private Button documento = new MButton(FontAwesome.BOOK, "Documento", this::verDocumento);
    private Button incidencia = new MButton(FontAwesome.EXCLAMATION_CIRCLE, "Incidencia", this::verIncidencia);
    private Button modificar = new MButton(FontAwesome.EDIT, "Modificar", this::modificar);

    private MTable<Recibo> recibosList = new MTable<>(Recibo.class)
            .withProperties("numRecibo", "importe", "mc", "fEmision", "fEfecto", "situacion", "fSituacion")
            .withColumnHeaders("Núm Recibo", "Importe", "MC", "F. Emision", "F. Efecto", "Situación", "F. Situación")
            .setSortableProperties("numRecibo", "importe")
            .withFullWidth();
    
    private MVerticalLayout titleLayout = new MVerticalLayout();
    
    private MHorizontalLayout rowCol1 = new MHorizontalLayout();
	private MHorizontalLayout rowCol2 = new MHorizontalLayout();
	private MHorizontalLayout rowCol3 = new MHorizontalLayout();
	private MHorizontalLayout rowCol4 = new MHorizontalLayout();
	private MHorizontalLayout rowCol5 = new MHorizontalLayout();
	private MHorizontalLayout rowCol6 = new MHorizontalLayout();

	private MVerticalLayout headerLayout = new MVerticalLayout();
	
	private ReciboDao reciboDao = null;
	
	public Recibos(){
		reciboDao = new ReciboDaoImpl();
	}
	
	@Override
	protected void init(VaadinRequest request) {
		
		titleLayout.addComponent(title);
		titleLayout.setSizeFull();
		
		rowCol1.addComponents(ramo, ramoDecription, nPoliza, nPolizaDecription);
		rowCol1.setSizeFull();
		rowCol2.addComponents(mutualista, mutualistaDecription, nif, nifDecription);
		rowCol2.setSizeFull();
		rowCol3.addComponents(oasegurado, oaseguradoDecription, fecEfecto, fecEfectoDecription);
		rowCol3.setSizeFull();
		rowCol4.addComponents(modalidad, modalidadDecription, franquicia, franquiciaDecription, vencimiento, vencimientoDecription);
		rowCol4.setSizeFull();
		rowCol5.addComponents(dirPago, dirPagoDecription, ccc, cccDecription);
		rowCol5.setSizeFull();

		headerLayout.addComponents(rowCol1, rowCol2, rowCol3, rowCol4, rowCol5);
		headerLayout.setHeight(6, Unit.CM);
		
		rowCol6.addComponents(consultar, historico, documento, incidencia, modificar);
		rowCol6.setSizeFull();
		
		loadCabecera();
		setContent(new MVerticalLayout(title, headerLayout, rowCol6, recibosList));
		loadRecibos();
	}
	
    public void consultar(ClickEvent clickEvent) {
		BrowserWindowOpener opener = new BrowserWindowOpener(PopupVaadin.class);
		opener.setFeatures("height=200,width=300,resizable");

    	opener.setWindowName("Consultar");
    	opener.extend(consultar);
    }
    
    public void verHistorico(ClickEvent e) {
		BrowserWindowOpener opener = new BrowserWindowOpener(PopupVaadin.class);
		opener.setFeatures("height=200,width=300,resizable");

    	opener.extend(historico);    	
    }
    
    public void verDocumento(ClickEvent e) {
		BrowserWindowOpener opener = new BrowserWindowOpener(PopupVaadin.class);
		opener.setFeatures("height=200,width=300,resizable");

    	opener.extend(documento);
    }

    public void verIncidencia(ClickEvent e) {
		BrowserWindowOpener opener = new BrowserWindowOpener(PopupVaadin.class);
		opener.setFeatures("height=200,width=300,resizable");

    	opener.extend(incidencia);
    }
    
    public void modificar(ClickEvent e) {
		BrowserWindowOpener opener = new BrowserWindowOpener(PopupVaadin.class);
		opener.setFeatures("height=200,width=300,resizable");

    	opener.extend(modificar);
    }

    private void loadRecibos(){
    	recibosList.setRows(reciboDao.getAll());
    }
    
    private void loadCabecera(){
    	List<CabeceraRecibo> cabeceraList = reciboDao.getAllCabecera();

    	for (int i = 0; i < cabeceraList.size(); i++){
    		//CabeceraRecibo cabecera = (CabeceraRecibo) reciboDao.getAllCabecera().get(i);
    	    CabeceraRecibo cabecera = cabeceraList.get(i);
    	
			if(cabecera.getNombreCabecera().equals(ramo.getValue())){
				ramoDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(mutualista.getValue())){
				mutualistaDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(oasegurado.getValue())){
				oaseguradoDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(modalidad.getValue())){
				modalidadDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(dirPago.getValue())){
				dirPagoDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(nPoliza.getValue())){
				nPolizaDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(nif.getValue())){
				nifDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(fecEfecto.getValue())){
				fecEfectoDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(franquicia.getValue())){
				franquiciaDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(vencimiento.getValue())){
				vencimientoDecription.setCaption(cabecera.getDescripcionCabecera());
			}
			
			if(cabecera.getNombreCabecera().equals(ccc.getValue())){
				cccDecription.setCaption(cabecera.getDescripcionCabecera());
			}
		}
    }    
}
