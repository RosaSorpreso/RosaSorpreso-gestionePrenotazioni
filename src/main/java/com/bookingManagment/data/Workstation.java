package com.bookingManagment.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workstation")
@Builder(setterPrefix = "with")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private WorkstationType workstationType;
    @Column(name = "max_user")
    private int maxUser;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
