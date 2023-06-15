package ru.sbrf.hackaton.app.model;

import lombok.Data;
import org.bson.types.ObjectId;

/*
 * @created 15.06.2023
 * @author alexander
 */
@Data
public class Session {
    private ObjectId id;
    private Long createDate;
    private Long expireDate;
}
