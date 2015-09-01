package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.abet.*;
import co.edu.usbcali.abet.dto.CategoriaDTO;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
@Component
@ManagedBean
@ViewScoped
public class CategoriaView {
    private InputText txtNombreCategoria;
    private InputText txtIdRubrica_Rubrica;
    private InputText txtIdCategoria;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CategoriaDTO> data;
    private CategoriaDTO selectedCategoria;
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;

    public CategoriaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            CategoriaDTO categoriaDTO = (CategoriaDTO) e.getObject();

            if (txtNombreCategoria == null) {
                txtNombreCategoria = new InputText();
            }

            txtNombreCategoria.setValue(categoriaDTO.getNombreCategoria());

            if (txtIdRubrica_Rubrica == null) {
                txtIdRubrica_Rubrica = new InputText();
            }

            txtIdRubrica_Rubrica.setValue(categoriaDTO.getIdRubrica_Rubrica());

            if (txtIdCategoria == null) {
                txtIdCategoria = new InputText();
            }

            txtIdCategoria.setValue(categoriaDTO.getIdCategoria());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtNombreCategoria != null) {
            txtNombreCategoria.setValue(null);
            txtNombreCategoria.setDisabled(true);
        }

        if (txtIdRubrica_Rubrica != null) {
            txtIdRubrica_Rubrica.setValue(null);
            txtIdRubrica_Rubrica.setDisabled(true);
        }

        if (txtIdCategoria != null) {
            txtIdCategoria.setValue(null);
            txtIdCategoria.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        if (btnModify != null) {
            btnModify.setDisabled(true);
        }

        if (btnClear != null) {
            btnClear.setDisabled(false);
        }

        return "";
    }

    public void listener_txtId() {
        Categoria entity = null;

        try {
            Long idCategoria = new Long(txtIdCategoria.getValue().toString());
            entity = businessDelegatorView.getCategoria(idCategoria);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtNombreCategoria.setDisabled(false);
            txtIdRubrica_Rubrica.setDisabled(false);
            txtIdCategoria.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtNombreCategoria.setValue(entity.getNombreCategoria());
            txtNombreCategoria.setDisabled(false);
            txtIdRubrica_Rubrica.setValue(entity.getRubrica().getIdRubrica());
            txtIdRubrica_Rubrica.setDisabled(false);
            txtIdCategoria.setValue(entity.getIdCategoria());
            txtIdCategoria.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            businessDelegatorView.saveCategoria(FacesUtils.checkLong(
                    txtIdCategoria),
                FacesUtils.checkString(txtNombreCategoria),
                FacesUtils.checkLong(txtIdRubrica_Rubrica));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            businessDelegatorView.deleteCategoria(FacesUtils.checkLong(
                    txtIdCategoria));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            businessDelegatorView.updateCategoria(FacesUtils.checkLong(
                    txtIdCategoria),
                FacesUtils.checkString(txtNombreCategoria),
                FacesUtils.checkLong(txtIdRubrica_Rubrica));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
            action_clear();
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String actionDeleteDataTableEditable() {
        try {
            if (txtIdCategoria == null) {
                txtIdCategoria = new InputText();
            }

            txtIdCategoria.setValue(selectedCategoria.getIdCategoria());

            businessDelegatorView.deleteCategoria(FacesUtils.checkLong(
                    txtIdCategoria));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedCategoria);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long idCategoria, String nombreCategoria,
        Long idRubrica_Rubrica) throws Exception {
        try {
            businessDelegatorView.updateCategoria(idCategoria, nombreCategoria,
                idRubrica_Rubrica);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CategoriaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreCategoria() {
        return txtNombreCategoria;
    }

    public void setTxtNombreCategoria(InputText txtNombreCategoria) {
        this.txtNombreCategoria = txtNombreCategoria;
    }

    public InputText getTxtIdRubrica_Rubrica() {
        return txtIdRubrica_Rubrica;
    }

    public void setTxtIdRubrica_Rubrica(InputText txtIdRubrica_Rubrica) {
        this.txtIdRubrica_Rubrica = txtIdRubrica_Rubrica;
    }

    public InputText getTxtIdCategoria() {
        return txtIdCategoria;
    }

    public void setTxtIdCategoria(InputText txtIdCategoria) {
        this.txtIdCategoria = txtIdCategoria;
    }

    public List<CategoriaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCategoria();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CategoriaDTO> categoriaDTO) {
        this.data = categoriaDTO;
    }

    public CategoriaDTO getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(CategoriaDTO categoria) {
        this.selectedCategoria = categoria;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }
}
