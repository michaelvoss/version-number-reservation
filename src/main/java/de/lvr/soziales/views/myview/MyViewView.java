package de.lvr.soziales.views.myview;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
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
import java.util.ArrayList;
import java.util.List;

@PageTitle("My View")
@Route(value = "")
@RouteAlias(value = "")
public class MyViewView extends Composite<VerticalLayout> {

    public MyViewView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H1 h1 = new H1();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        MultiSelectListBox textItems = new MultiSelectListBox();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Button buttonPrimary = new Button();
        Hr hr = new Hr();
        TextField textField = new TextField();
        Hr hr2 = new Hr();
        NumberField numberField = new NumberField();
        NumberField numberField2 = new NumberField();
        NumberField numberField3 = new NumberField();
        NumberField numberField4 = new NumberField();
        TextField textField2 = new TextField();
        Hr hr3 = new Hr();
        TextField textField3 = new TextField();
        Hr hr4 = new Hr();
        TextArea textArea = new TextArea();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        Paragraph textMedium = new Paragraph();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        h1.setText("Version Number Reservation");
        h1.setWidth("max-content");
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn2.getStyle().set("flex-grow", "1");
        textItems.setWidth("102px");
        textItems.getStyle().set("flex-grow", "1");
        setMultiSelectListBoxSampleData(textItems);
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Reserve Version Number");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        textField.setLabel("User");
        textField.setWidth("250px");
        numberField.setLabel("Major Version");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.START, numberField);
        numberField.setWidth("100%");
        numberField2.setLabel("Minor Version");
        numberField2.setWidth("100%");
        numberField3.setLabel("Patch");
        numberField3.setWidth("100%");
        numberField4.setLabel("Build Number");
        numberField4.setWidth("100%");
        textField2.setLabel("Add-On");
        textField2.setWidth("100%");
        textField3.setLabel("Branch");
        textField3.setWidth("100%");
        textArea.setLabel("Beschreibung");
        textArea.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.setHeight("min-content");
        textMedium.setText(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        textMedium.setWidth("100%");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        getContent().add(layoutRow);
        layoutRow.add(h1);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(textItems);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(buttonPrimary);
        layoutColumn3.add(hr);
        layoutColumn3.add(textField);
        layoutColumn3.add(hr2);
        layoutColumn3.add(numberField);
        layoutColumn3.add(numberField2);
        layoutColumn3.add(numberField3);
        layoutColumn3.add(numberField4);
        layoutColumn3.add(textField2);
        layoutColumn3.add(hr3);
        layoutColumn3.add(textField3);
        layoutColumn3.add(hr4);
        layoutColumn3.add(textArea);
        layoutRow2.add(layoutColumn4);
        getContent().add(layoutRow3);
        layoutRow3.add(textMedium);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectListBoxSampleData(MultiSelectListBox multiSelectListBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectListBox.setItems(sampleItems);
        multiSelectListBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
        multiSelectListBox.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
