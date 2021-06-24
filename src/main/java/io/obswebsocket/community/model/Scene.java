package io.obswebsocket.community.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Scene {
    private String sceneName;
    private Integer sceneIndex;
    private Boolean isGroup; // maybe a new feature?

    // Sources on scenes has moved to the separate GetSceneItemList request
//    private List<Source> sources;

//    public List<Source> getSourcesIncludingGroupChildren() {
//        List<Source> allSources = new ArrayList<>();
//        this.sources.forEach(source -> {
//            allSources.add(source);
//            if (source.getGroupChildren() != null && source.getGroupChildren().size() > 0) {
//                allSources.addAll(source.getGroupChildren());
//            }
//        });
//
//        return allSources;
//    }
}
