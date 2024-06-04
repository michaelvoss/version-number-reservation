package de.lvr.soziales.versionreservation.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import de.lvr.soziales.versionreservation.backend.entities.ApplicationEntity;
import de.lvr.soziales.versionreservation.backend.entities.VersionEntity;
import de.lvr.soziales.versionreservation.backend.repositories.ApplicationRepository;
import de.lvr.soziales.versionreservation.backend.repositories.VersionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("My View")
@Route(value = "")
@RouteAlias(value = "")
public class VersionReservationView extends Composite<VerticalLayout> implements HasValue.ValueChangeListener {
    public static final String BTN_RESERVE_TEXT = "Versions-Nummer reservieren";
    public static final String LABEL_USER_ID = "User";
    public static final String LABEL_MAJOR_VERSION = "Major Version";
    public static final String LABEL_MINOR_VERSION = "Minor Version";
    public static final String LABEL_PATCH = "Patch";
    public static final String LABEL_BUILD_NUMMER = "Build-Nummer";
    public static final String LABEL_ADD_ON = "Add-On";
    public static final String LABEL_BRANCH = "Branch";
    public static final String LABEL_BESCHREIBUNG = "Beschreibung";
    
    @Autowired
    ApplicationRepository appRepo;
    
    @Autowired
    VersionRepository versionRepo;
    
    private ListBox<ApplicationEntity> applicationListBox;
    private TextField userId = new TextField();
    private NumberField majorVersionNumber = new NumberField();
    private NumberField minorVersionNumber = new NumberField();
    private NumberField patchNumber = new NumberField();
    private NumberField buildNumber = new NumberField();
    private TextField versionAddOn = new TextField();
    private TextField branchName = new TextField();
    private TextArea beschreibung = new TextArea();
    private Button btnReserveVersion;
    private Paragraph footerText = new Paragraph();
    
    public VersionReservationView() {
        this.addHeaderRow();
        this.addContentRow();
        this.addFooterRow();
        
        
        this.getContent().setWidth("100%");
        this.getContent().getStyle().set("flex-grow", "1");
    }
    
    private void addFooterRow() {
        HorizontalLayout footerRow = new HorizontalLayout();
        footerRow.addClassName(Gap.MEDIUM);
        footerRow.setWidth("100%");
        footerRow.setHeight("min-content");
        
        this.footerText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.footerText.setWidth("100%");
        this.footerText.getStyle().set("font-size", "var(--lumo-font-size-m)");
        footerRow.add(this.footerText);
        
        this.getContent().add(footerRow);
    }
    
    private void addContentRow() {
        HorizontalLayout contentRow = new HorizontalLayout();
        contentRow.addClassName(Gap.MEDIUM);
        contentRow.setWidth("100%");
        contentRow.getStyle().set("flex-grow", "1");
        
        this.createApplicationList();
        
        VerticalLayout dataColumn = new VerticalLayout();
        dataColumn.setWidth("100%");
        dataColumn.getStyle().set("flex-grow", "1");
        
        this.btnReserveVersion = new Button();
        this.btnReserveVersion.setText(VersionReservationView.BTN_RESERVE_TEXT);
        this.btnReserveVersion.setWidth("min-content");
        this.btnReserveVersion.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        dataColumn.add(this.btnReserveVersion);
        
        Hr hr1 = new Hr();
        Hr hr2 = new Hr();
        Hr hr3 = new Hr();
        Hr hr4 = new Hr();
        
        dataColumn.add(hr1);
        
        this.userId.setLabel(VersionReservationView.LABEL_USER_ID);
        this.userId.setWidth("250px");
        dataColumn.add(this.userId);
        
        dataColumn.add(hr2);
        
        this.majorVersionNumber.setLabel(VersionReservationView.LABEL_MAJOR_VERSION);
        this.majorVersionNumber.setWidth("100%");
        dataColumn.setAlignSelf(FlexComponent.Alignment.START, this.majorVersionNumber);
        dataColumn.add(this.majorVersionNumber);
        
        this.minorVersionNumber.setLabel(VersionReservationView.LABEL_MINOR_VERSION);
        this.minorVersionNumber.setWidth("100%");
        dataColumn.setAlignSelf(FlexComponent.Alignment.START, this.minorVersionNumber);
        dataColumn.add(this.minorVersionNumber);
        
        this.patchNumber.setLabel(VersionReservationView.LABEL_PATCH);
        this.patchNumber.setWidth("100%");
        dataColumn.setAlignSelf(FlexComponent.Alignment.START, this.patchNumber);
        dataColumn.add(this.patchNumber);
        
        this.buildNumber.setLabel(VersionReservationView.LABEL_BUILD_NUMMER);
        this.buildNumber.setWidth("100%");
        dataColumn.setAlignSelf(FlexComponent.Alignment.START, this.buildNumber);
        dataColumn.add(this.buildNumber);
        
        this.versionAddOn.setLabel(VersionReservationView.LABEL_ADD_ON);
        this.versionAddOn.setWidth("100%");
        dataColumn.setAlignSelf(FlexComponent.Alignment.START, this.versionAddOn);
        dataColumn.add(this.versionAddOn);
        
        dataColumn.add(hr3);
        
        this.branchName.setLabel(VersionReservationView.LABEL_BRANCH);
        this.branchName.setWidth("100%");
        dataColumn.setAlignSelf(FlexComponent.Alignment.START, this.branchName);
        dataColumn.add(this.branchName);
        
        dataColumn.add(hr4);
        
        this.beschreibung.setLabel(VersionReservationView.LABEL_BESCHREIBUNG);
        this.beschreibung.setWidth("100%");
        dataColumn.setAlignSelf(FlexComponent.Alignment.START, this.beschreibung);
        dataColumn.add(this.beschreibung);
        
        contentRow.add(this.applicationListBox);
        contentRow.add(dataColumn);
        
        this.getContent().add(contentRow);
    }
    
    private void createApplicationList() {
        this.applicationListBox = new ListBox<ApplicationEntity>();
        this.applicationListBox.setWidth("400px");
        this.applicationListBox.getStyle().set("flex-grow", "1");
        this.applicationListBox.setItemLabelGenerator(item -> ((ApplicationEntity) item).getName());
        this.applicationListBox.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((ApplicationEntity) item).isDisabled()));
        this.applicationListBox.addValueChangeListener(this);
    }
    
    private void addHeaderRow() {
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.addClassName(Gap.MEDIUM);
        headerLayout.setWidth("100%");
        headerLayout.setHeight("min-content");
        
        H1 h1 = new H1();
        h1.setText("Versions-Nummer Reservieren");
        h1.setWidth("max-content");
        
        headerLayout.add(h1);
        this.getContent().add(headerLayout);
    }
    
    @PostConstruct
    private void loadData() {
        this.populateApplicationList();
    }
    
    private void populateApplicationList() {
        List<ApplicationEntity> applicationItems = this.appRepo.findAll();
        this.applicationListBox.setItems(applicationItems);
    }
    
    @Override
    public void valueChanged(HasValue.ValueChangeEvent event) {
        ApplicationEntity neueApplikation = (ApplicationEntity)event.getValue();
        if (neueApplikation != null) {
            List<VersionEntity> versionen = this.versionRepo.findByApplicationId(neueApplikation.getOid());
            if ((versionen != null) && (!versionen.isEmpty())) {
                this.zeigeVersion(versionen.get(versionen.size() - 1));
            } else {
                this.clearVersion();
            }
        }
    }
    
    private void clearVersion() {
        this.majorVersionNumber.setValue(0d);
        this.minorVersionNumber.setValue(0d);
        this.patchNumber.setValue(0d);
        this.buildNumber.setValue(0d);
        this.versionAddOn.setValue("");
        this.branchName.setValue("");
        this.beschreibung.setValue("");
        this.userId.setValue("");
    }
    
    private void zeigeVersion(VersionEntity version) {
        this.majorVersionNumber.setValue(version.getMajorVersion() == null?0d:version.getMajorVersion().doubleValue());
        this.minorVersionNumber.setValue(version.getMinorVersion() == null?0d:version.getMinorVersion().doubleValue());
        this.patchNumber.setValue(version.getPatchNumber() == null?0d:version.getPatchNumber().doubleValue());
        this.buildNumber.setValue(version.getBuildNumber() == null?0d:version.getBuildNumber().doubleValue());
        this.versionAddOn.setValue(version.getAddOn() == null?"":version.getAddOn());
        this.branchName.setValue(version.getBranchName() == null?"":version.getBranchName());
        this.beschreibung.setValue(version.getInfoText() == null?"":version.getInfoText());
        this.userId.setValue(version.getUserId() == null?"":version.getUserId());
    }
}
