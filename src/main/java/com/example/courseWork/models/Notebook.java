package com.example.courseWork.models;

import javax.persistence.*;

@Entity
@Table(name = "notebook")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "diagonal")
    private double diagonal;

    @Column(name = "color")
    private String color;

    @Column(name = "operating_system")
    private String operatingSystem;

    @Column(name = "processor_family")
    private String processorFamily;

    @Column(name="number_of_processor_cores")
    private String numberOfProcessorCores;

    @Column(name = "processor_name")
    private String processorName;

    @Column(name = "ram_size")
    private String ramSize;

    @Column(name = "ram_type") // тип оперативной памяти *DDR4*
    private String ramType;

    @Column(name = "screen_resolution")
    private String screenResolution;

    @Column(name = "type_of_video_card")
    private String typeOfVideoCard;

    @Column(name = "video_card_model")
    private String videoCardModel;

    @Column(name = "drive_type") // тип накопителя
    private String driveType;

    @Column(name = "hdd_storage_capacity") // Объем накопителя HDD
    private String hddStorageCapacity;

    @Column(name = "sdd_storage_capacity") // Объем накопителя SDD
    private String sddStorageCapacity;

    @Column(name = "weight")
    private String weight;

    @Column(name = "max_running_time")
    private String maxRunningTime;

    //    @NotNull(message = "category can't be null")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    //    @NotNull(message = "manufacturer can't be null")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public Notebook() {
    }

    public Notebook(double diagonal, String color, String operatingSystem, String processorFamily, String numberOfProcessorCores, String processorName, String ramSize, String ramType, String screenResolution, String typeOfVideoCard, String videoCardModel, String driveType, String hddStorageCapacity, String sddStorageCapacity, String weight, String maxRunningTime) {
        this.diagonal = diagonal;
        this.color = color;
        this.operatingSystem = operatingSystem;
        this.processorFamily = processorFamily;
        this.numberOfProcessorCores = numberOfProcessorCores;
        this.processorName = processorName;
        this.ramSize = ramSize;
        this.ramType = ramType;
        this.screenResolution = screenResolution;
        this.typeOfVideoCard = typeOfVideoCard;
        this.videoCardModel = videoCardModel;
        this.driveType = driveType;
        this.hddStorageCapacity = hddStorageCapacity;
        this.sddStorageCapacity = sddStorageCapacity;
        this.weight = weight;
        this.maxRunningTime = maxRunningTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProcessorFamily() {
        return processorFamily;
    }

    public void setProcessorFamily(String processorFamily) {
        this.processorFamily = processorFamily;
    }

    public String getNumberOfProcessorCores() {
        return numberOfProcessorCores;
    }

    public void setNumberOfProcessorCores(String numberOfProcessorCores) {
        this.numberOfProcessorCores = numberOfProcessorCores;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getTypeOfVideoCard() {
        return typeOfVideoCard;
    }

    public void setTypeOfVideoCard(String typeOfVideoCard) {
        this.typeOfVideoCard = typeOfVideoCard;
    }

    public String getVideoCardModel() {
        return videoCardModel;
    }

    public void setVideoCardModel(String videoCardModel) {
        this.videoCardModel = videoCardModel;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getHddStorageCapacity() {
        return hddStorageCapacity;
    }

    public void setHddStorageCapacity(String hddStorageCapacity) {
        this.hddStorageCapacity = hddStorageCapacity;
    }

    public String getSddStorageCapacity() {
        return sddStorageCapacity;
    }

    public void setSddStorageCapacity(String sddStorageCapacity) {
        this.sddStorageCapacity = sddStorageCapacity;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMaxRunningTime() {
        return maxRunningTime;
    }

    public void setMaxRunningTime(String maxRunningTime) {
        this.maxRunningTime = maxRunningTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
