#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.mapper;

public interface EntityMapper<TEntity, TDto> {

    TDto toDto(TEntity entity);

    TEntity toEntity(TDto dto);
}
