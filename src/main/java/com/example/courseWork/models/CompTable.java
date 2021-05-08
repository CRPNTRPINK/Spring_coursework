package com.example.courseWork.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "comp_table")
public class CompTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="operating_system")
    private String operatingSystem;

    @Column(name="charging_connector_type")
    private String ChargingConnectorType;

    @Column(name="diagonal")
    private String Diagonal;

    @Column(name="screen_resolution")
    private String screenResolution;

    @Column(name = "color")
    private String color;

    @Column(name="memory_size")
    private String memorySize;

    @Column(name="ram_size")
    private String ramSize;

    @Column(name="number_of_processor_cores")
    private String numberOfProcessorCores;

    @Column(name="battery_type")
    private String batteryType;

    @Column(name="battery_capacity")
    private String batteryCapacity;

    @Column(name = "filename")
    private String filename;

    @Column(name = "stylus")
    private String stylus;

    @Column(name = "view")
    private int view;


    //    @NotNull(message = "category can't be null")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    //    @NotNull(message = "manufacturer can't be null")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public CompTable() {
    }

    public CompTable(String name, String operatingSystem, String chargingConnectorType, String diagonal, String screenResolution, String color, String memorySize, String ramSize, String numberOfProcessorCores, String batteryType, String batteryCapacity, String filename, String stylus) {
        this.name = name;
        this.operatingSystem = operatingSystem;
        ChargingConnectorType = chargingConnectorType;
        Diagonal = diagonal;
        this.screenResolution = screenResolution;
        this.color = color;
        this.memorySize = memorySize;
        this.ramSize = ramSize;
        this.numberOfProcessorCores = numberOfProcessorCores;
        this.batteryType = batteryType;
        this.batteryCapacity = batteryCapacity;
        this.filename = filename;
        this.stylus = stylus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getChargingConnectorType() {
        return ChargingConnectorType;
    }

    public void setChargingConnectorType(String chargingConnectorType) {
        ChargingConnectorType = chargingConnectorType;
    }


    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(String memorySize) {
        this.memorySize = memorySize;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getNumberOfProcessorCores() {
        return numberOfProcessorCores;
    }

    public void setNumberOfProcessorCores(String numberOfProcessorCores) {
        this.numberOfProcessorCores = numberOfProcessorCores;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getStylus() {
        return stylus;
    }

    public void setStylus(String stylus) {
        this.stylus = stylus;
    }

    public void setDiagonal(String diagonal) {
        Diagonal = diagonal;
    }

    public String getDiagonal() {
        return Diagonal;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @JsonIgnore
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonIgnore
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
