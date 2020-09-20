/* Tags.groovy
 * 
 * Utils script for git tag management.
 * 
 */

public boolean existsTag(String repoURL, String tag) {
    return "1".equals(sh(returnStatus: true, "./search_tag.sh $repoURL $tag"))
}

class ProjectInfo {
    String name;
    String version;
}

class ComponentInfo {
    String name;
    String version;
    ArrayList<ProjectInfo> projects;
}

public createJson() {
    echo '1'
    def data = readJSON text: '{}'
    echo '2'
    ProjectInfo projectInfo = new ProjectInfo();
    echo '3'
    projectInfo.name = 'onepay-ui'
    echo '4'
    projectInfo.version = '1.0.0'
    echo '5'
    ComponentInfo componentInfo = new ComponentInfo()
    echo '6'
    componentInfo.name = 'OnePay'
    echo '7'
    componentInfo.version = '1.0.0'
    echo '8'
    componentInfo.projects = new ArrayList<ProjectInfo>();
    echo '9'
    componentInfo.projects.add(projectInfo);
    echo '10'
    writeJSON(file: 'message1.json', json: componentInfo, pretty: 4)
}