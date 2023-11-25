package org.sopkaton.Project.dto.request;

import java.util.List;

public record DIslikePostRequest (
    List<Long> postIdList
){

}